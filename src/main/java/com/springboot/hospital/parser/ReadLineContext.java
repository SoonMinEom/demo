package com.springboot.hospital.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext <T>{

    private Parser<T> parser;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readByLine(String filename) throws IOException {
        List<T> result = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));

        String str;
        br.readLine();
        while ((str = br.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.printf("예외가 발생했습니다 정보 : %s\n", str);
            }
        }

        br.close();

        return result;
    }

}
