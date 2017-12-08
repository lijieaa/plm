package com.visizen.po;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

public class PageRequestPo extends PageRequest{

    public PageRequestPo(int page, int size) {
        super(page-1, size);
    }

    public PageRequestPo(int page, int size, Sort.Direction direction, String... properties) {
        super(page-1, size, direction, properties);
    }

    public PageRequestPo(int page, int size, Sort sort) {
        super(page-1, size, sort);
    }
}
