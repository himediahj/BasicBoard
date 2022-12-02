package com.practice.board.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDTO {
    private int idx;
    @NotBlank(message = "아이디는 필수 입력값입니다.")
    private String uid;
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String pw;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z가-힣]{1,40}", message = "영문과 한글만 입력 가능합니다.")
    private String uname;

    private String uuid;
}
