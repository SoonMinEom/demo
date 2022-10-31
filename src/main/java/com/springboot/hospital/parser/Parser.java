package com.springboot.hospital.parser;

public interface Parser<T> {

    T parse(String str);
}
