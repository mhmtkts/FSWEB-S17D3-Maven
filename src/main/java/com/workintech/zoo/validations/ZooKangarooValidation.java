package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangarooValidation {
    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, Integer id, boolean b) {
        if (b) {
            if (!kangaroos.containsKey(id)) {
                throw new ZooException("Record is not exist" + id , HttpStatus.NOT_FOUND);
            }
        } else {
            if (kangaroos.containsKey(id)) {
                throw new ZooException("Record is exist" + id , HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static void checkKangarooWeight(Double weight) {
        if (weight == null || weight <= 0) {
            throw new ZooException("Weight must be a positive number"+ weight, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdValid(Integer id) {
        if (id <= 0 || id == null) {
            throw new ZooException("Id must be a positive number"+ id, HttpStatus.BAD_REQUEST);
        }
    }
}
