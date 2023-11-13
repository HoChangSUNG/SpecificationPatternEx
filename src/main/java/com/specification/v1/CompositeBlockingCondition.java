package com.specification.v1;

public abstract class CompositeBlockingCondition implements BlockingCondition {

    @Override
    public BlockingCondition and(BlockingCondition other) {
        return new AndBlockingCondition(this,other);
    }

    @Override
    public BlockingCondition or(BlockingCondition other) {
        return new OrBlockingCondition(this,other);
    }

    @Override
    public BlockingCondition not() {
        return new NotBlockingCondition(this);
    }
}
