package com.visizen.advice;

import com.visizen.dto.ResultDto;
import com.visizen.dto.ResultPage;
import org.springframework.core.MethodParameter;
import org.springframework.data.rest.webmvc.support.RepositoryConstraintViolationExceptionMessage;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装返回json
 */
@ControllerAdvice
public class ResultAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof PagedResources) {
            PagedResources pagedResources = (PagedResources) o;
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(200);
            resultDto.setMsg("执行成功！");
            ResultPage page = new ResultPage();
            page.setRows(pagedResources.getContent());
            page.setPage(pagedResources.getMetadata().getNumber());
            page.setRecords(pagedResources.getMetadata().getTotalElements());
            page.setSize(pagedResources.getMetadata().getSize());
            page.setTotal(pagedResources.getMetadata().getTotalPages());
            Map data = new HashMap<>();
            data.put("page", page);
            resultDto.setData(data);
            return resultDto;
        } else if (o instanceof Resource) {
            Resource resource = (Resource) o;
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(200);
            resultDto.setMsg("执行成功！");
            resultDto.setData(resource);
            return resultDto;
        } else if (o instanceof Resources) {
            Resources resources = (Resources) o;
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(200);
            resultDto.setMsg("执行成功！");
            resultDto.setData(resources.getContent());
            return resultDto;
        } else if (o instanceof RepositoryConstraintViolationExceptionMessage) {
            RepositoryConstraintViolationExceptionMessage msg = (RepositoryConstraintViolationExceptionMessage) o;
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(400);
            resultDto.setMsg("存在错误！");
            List<RepositoryConstraintViolationExceptionMessage.ValidationError> errors = msg.getErrors();
            List<String> data = new ArrayList<>();
            for (RepositoryConstraintViolationExceptionMessage.ValidationError error : errors) {
                data.add(error.getMessage());
            }
            resultDto.setData(data);
            return resultDto;
        }
        return o;
    }
}
