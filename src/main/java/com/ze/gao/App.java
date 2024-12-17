package com.ze.gao;

import com.ze.gao.parser.SpelVisitor;
import com.ze.gao.parser.base.SimpleParserLexer;
import com.ze.gao.parser.base.SimpleParserParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static class PurchaseItemEntity {
        private Long id;
        private Integer count;
        private Boolean available;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Boolean getAvailable() {
            return available;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "PurchaseItemEntity{" +
                    "id=" + id +
                    ", count=" + count +
                    ", available=" + available +
                    '}';
        }
    }

    public static class PurchaseEntity {
        private List<PurchaseItemEntity> items;

        public List<PurchaseItemEntity> getItems() {
            return items;
        }

        public void setItems(List<PurchaseItemEntity> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "PurchaseEntity{" +
                    "items=" + items +
                    '}';
        }
    }

    public static class Contract {
        private PurchaseEntity purchasePart;

        public PurchaseEntity getPurchasePart() {
            return purchasePart;
        }

        public void setPurchasePart(PurchaseEntity purchasePart) {
            this.purchasePart = purchasePart;
        }

        @Override
        public String toString() {
            return "Contract{" +
                    "purchasePart=" + purchasePart +
                    '}';
        }
    }

    public static void main( String[] args ) throws NoSuchMethodException {
        String input = "purchasePart.items[id=12 and available=getTrue(id)].count = purchasePart.items[id=11].count";
        SimpleParserLexer lexer = new SimpleParserLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParserParser parser = new SimpleParserParser(tokens);
        SimpleParserParser.StatementContext tree = parser.statement();

        Contract contract = new Contract();
        contract.setPurchasePart(new PurchaseEntity());
        contract.getPurchasePart().setItems(new ArrayList<>());
        PurchaseItemEntity item1 = new PurchaseItemEntity();
        item1.setCount(10);
        item1.setId(11L);
        item1.setAvailable(true);
        contract.getPurchasePart().getItems().add(item1);

        PurchaseItemEntity item2 = new PurchaseItemEntity();
        item2.setCount(11);
        item2.setId(12L);
        item2.setAvailable(true);
        contract.getPurchasePart().getItems().add(item2);
        System.out.printf("before: %s%n", contract);

        StandardEvaluationContext context = new StandardEvaluationContext(contract);
        context.registerFunction("getTrue", Utils.class.getMethod("getTrue", Long.class));
        SpelVisitor visitor = new SpelVisitor(context);
        String spelExpression = visitor.visit(tree);

        System.out.println("Original DSL: " + input);
        System.out.println("Converted SpEL: " + spelExpression);

        SpelExpressionParser parser1 = visitor.getParser();

        Object value = parser1.parseExpression(spelExpression).getValue(context);
        System.out.printf("after: %s%n", contract);
    }

    public static class Utils {
        public static boolean getTrue(Long id) {
            return true;
        }
    }
}
