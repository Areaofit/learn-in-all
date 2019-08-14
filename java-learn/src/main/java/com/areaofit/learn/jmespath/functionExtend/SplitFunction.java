package com.areaofit.learn.jmespath.functionExtend;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

import java.util.ArrayList;
import java.util.List;

public class SplitFunction extends BaseFunction {

    public SplitFunction() {
        super(ArgumentConstraints.typeOf(JmesPathType.STRING),
                ArgumentConstraints.typeOf(JmesPathType.STRING));
    }

    @Override
    protected <T> T callFunction(Adapter<T> adapter, List<FunctionArgument<T>> list) {
        String source = adapter.toString(list.get(0).value());
        String regex = adapter.toString(list.get(1).value());
        String[] strings = source.split(regex);
        if (strings.length == 0)
        {
            strings = source.split(regex, -1);
        }
        List<T> array = new ArrayList<>(strings.length);
        for (String s : strings)
        {
            if (s.isEmpty())
            {
                array.add(adapter.createNull());
            }
            else
            {
                array.add(adapter.createString(s));
            }
        }
        return adapter.createArray(array);
    }
}
