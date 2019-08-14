package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.List;

public class SetNumFunction extends BaseFunction {

    public SetNumFunction() {
        super(
                ArgumentConstraints.typeOf(JmesPathType.BOOLEAN),
                ArgumentConstraints.typeOf(JmesPathType.NUMBER),
                ArgumentConstraints.typeOf(JmesPathType.NUMBER));
    }

    @Override
    protected <T> T callFunction(Adapter<T> runtime, List<FunctionArgument<T>> arguments) {
        boolean flag =  Boolean.valueOf(runtime.toString(arguments.get(0).value()));
        double number;
        if (flag)
        {
            number = runtime.toNumber(arguments.get(1).value()).doubleValue();
        }
        else
        {
            number = runtime.toNumber(arguments.get(2).value()).doubleValue();
        }
        return runtime.createNumber(number);
    }
}
