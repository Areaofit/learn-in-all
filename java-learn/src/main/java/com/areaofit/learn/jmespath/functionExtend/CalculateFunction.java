package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.List;

public class CalculateFunction extends BaseFunction {

    public CalculateFunction() {
        super(
                ArgumentConstraints.typeOf(JmesPathType.NUMBER),
                ArgumentConstraints.typeOf(JmesPathType.STRING),//add/min/mul/div
                ArgumentConstraints.typeOf(JmesPathType.NUMBER)
        );
    }

    @Override
    protected <T> T callFunction(Adapter<T> runtime, List<FunctionArgument<T>> arguments) {
        Number num1 = runtime.toNumber(arguments.get(0).value());
        String operator = runtime.toString(arguments.get(1).value());
        Number num2 = runtime.toNumber(arguments.get(2).value());
        if (operator.equalsIgnoreCase("add")) {
            return runtime.createNumber(num1.floatValue() + num2.floatValue());
        } else if (operator.equalsIgnoreCase("sub")) {
            return runtime.createNumber(num1.floatValue() - num2.floatValue());
        } else if (operator.equalsIgnoreCase("mul")) {
            return runtime.createNumber(num1.floatValue() * num2.floatValue());
        } else if (operator.equalsIgnoreCase("div")) {
            return runtime.createNumber(num1.floatValue() / num2.floatValue());
        }
        return null;
    }
}
