package org.cmpiler.kotlin.interpreter.semantics.analyzer.implement;

import org.antlr.symtab.LocalScope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.cmpiler.kotlin.antlr.KotlinParser;
import org.cmpiler.kotlin.interpreter.semantics.analyzer.AbstractAnalyzer;

public class BlockAnalyzer extends AbstractAnalyzer {

    @Override
    public void enterBuildRule(ParserRuleContext context) {
        KotlinParser.BlockContext ctx = (KotlinParser.BlockContext) context;
        LocalScope l = new LocalScope(symtab.getCurrentScope());
        ctx.scope = l;
        symtab.pushScope(l);
    }

    @Override
    public void exitBuildRule(ParserRuleContext context) {
        symtab.popScope();
    }

    @Override
    public void evaluateRule(ParserRuleContext context) {
        KotlinParser.BlockContext ctx = (KotlinParser.BlockContext) context;
        symtab.setCurrentScope(ctx.scope);
    }
}
