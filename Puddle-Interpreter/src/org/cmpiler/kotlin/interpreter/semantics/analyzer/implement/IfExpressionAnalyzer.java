package org.cmpiler.kotlin.interpreter.semantics.analyzer.implement;

import org.antlr.symtab.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.cmpiler.kotlin.antlr.KotlinParser;
import org.cmpiler.kotlin.utils.ErrorDictionary;
import org.cmpiler.kotlin.interpreter.semantics.KotlinCodeValidator;
import org.cmpiler.kotlin.interpreter.semantics.analyzer.AbstractAnalyzer;
import org.cmpiler.kotlin.utils.ExpressionEvaluator;

public class IfExpressionAnalyzer extends AbstractAnalyzer {
    @Override
    public void enterBuildRule(ParserRuleContext context) {

    }

    @Override
    public void exitBuildRule(ParserRuleContext context) {

    }

    @Override
    public void evaluateRule(ParserRuleContext context) {
        KotlinParser.IfExpressionContext ctx = (KotlinParser.IfExpressionContext) context;
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        KotlinParser.ExpressionContext exp = ctx.expression();
        Type t = expEval.evaluate(exp);
        if(t == null)
            KotlinCodeValidator.reportCustomError(ErrorDictionary.TYPE_MISMATCH,ctx.start.getLine(),"", context.start.getLine());
        else if(!t.getName().equalsIgnoreCase("boolean"))
            KotlinCodeValidator.reportCustomError(ErrorDictionary.TYPE_MISMATCH,ctx.start.getLine(),"", context.start.getLine());
    }
}
