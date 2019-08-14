package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.List;

public class MatchWordsFunction extends BaseFunction {

    public MatchWordsFunction() {
        super(
                ArgumentConstraints.typeOf(JmesPathType.STRING),
                ArgumentConstraints.typeOf(JmesPathType.STRING)
        );
    }

    @Override
    protected <T> T callFunction(Adapter<T> runtime, List<FunctionArgument<T>> arguments) {
        String source = runtime.toString(arguments.get(0).value());
        String matchWords = runtime.toString(arguments.get(1).value());
        boolean result = source.equals(matchWords);
        return runtime.createBoolean(result);
    }
}
