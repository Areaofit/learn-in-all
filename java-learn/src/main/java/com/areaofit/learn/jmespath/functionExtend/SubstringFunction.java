package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.List;

public class SubstringFunction extends BaseFunction {

    public SubstringFunction() {
        super(
                ArgumentConstraints.typeOf(JmesPathType.STRING),
                ArgumentConstraints.typeOf(JmesPathType.NUMBER),
                ArgumentConstraints.typeOf(JmesPathType.NUMBER)
        );
    }

    @Override
    protected <T> T callFunction(Adapter<T> runtime, List<FunctionArgument<T>> arguments) {
        String source = runtime.toString(arguments.get(0).value());
        int from = runtime.toNumber(arguments.get(1).value()).intValue();
        int end = runtime.toNumber(arguments.get(2).value()).intValue();
        return runtime.createString(source.substring(from, end));
    }
}
