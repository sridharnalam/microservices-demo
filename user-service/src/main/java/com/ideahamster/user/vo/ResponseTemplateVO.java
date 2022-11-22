package com.ideahamster.user.vo;

import com.ideahamster.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
