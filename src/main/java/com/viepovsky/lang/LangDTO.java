package com.viepovsky.lang;

class LangDTO {
    private Long id;
    private String code;

    LangDTO(Lang lang) {
        id = lang.getId();
        code = lang.getCode();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
