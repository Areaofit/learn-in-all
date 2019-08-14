package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.Iterator;
import java.util.List;

public class ReplaceFunction extends BaseFunction {

    public ReplaceFunction() {
        super(
                ArgumentConstraints.typeOf(JmesPathType.STRING),
                ArgumentConstraints.arrayOf(ArgumentConstraints.typeOf(JmesPathType.ARRAY))
        );
    }

    @Override
    protected <T> T callFunction(Adapter<T> runtime, List<FunctionArgument<T>> arguments) {
        String source = runtime.toString(arguments.get(0).value());
        Iterator<T> values = runtime.toList(arguments.get(1).value()).iterator();
        while (values.hasNext()) {
            List<T> arr = runtime.toList(values.next());
            source = source.replaceAll(runtime.toString(arr.get(0)), runtime.toString(arr.get(1)));
        }
        return runtime.createString(source);
    }
}
