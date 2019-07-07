package com.bitcamp.web.domain;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * MemberDTO
 */
@Data @Component @Lazy
public class MemberDTO {
    private String   id 
                    ,name    
                    ,email   
                    ,password
                    ,grade   
                    ,introduce;   
    
    
}