package com.bruce.demo.enumerated;

public interface Competitor<T extends Competitor<T>> {
	Outcome compete(T t);
}
