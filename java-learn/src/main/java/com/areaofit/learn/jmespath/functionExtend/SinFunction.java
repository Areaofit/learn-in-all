package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.List;

public class SinFunction extends BaseFunction {

    public SinFunction() {
        super(ArgumentConstraints.typeOf(JmesPathType.NUMBER));
    }

    @Override
    protected <T> T callFunction(Adapter<T> adapter, List<FunctionArgument<T>> list) {
        T value = list.get(0).value();
        double n = adapter.toNumber(value).doubleValue();
        double s = Math.sin(n);
        return adapter.createNumber(s);
    }
}
