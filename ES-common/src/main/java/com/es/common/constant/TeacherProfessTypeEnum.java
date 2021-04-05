package com.es.common.constant;

/**
 * @author: fudy
 * @date: 2021/3/27 下午 05:56
 * @Decription: 教师职称枚举类
 **/
public enum TeacherProfessTypeEnum {
    /**
     * 教授
     */
    PROFESSOR(1, "教授"),
    /**
     * 副教授
     */
    ASSOCIATE_PROFESSOR(2, "副教授"),
    /**
     * 讲师
     */
    LECTURER(3, "讲师"),
    /**
     * 助教
     */
    TEACHING_ASSISTANT(4, "助教"),
    /**
     * 暂未分类
     */
    UN_KNOWN(5, "暂未分类"),
    ;

    private int code;

    private String message;

    TeacherProfessTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static TeacherProfessTypeEnum convertOrderChannelEnum(int code) {
        TeacherProfessTypeEnum orderChannel;
        switch (code) {
            case 1:
                orderChannel = PROFESSOR;
                break;
            case 2:
                orderChannel = ASSOCIATE_PROFESSOR;
                break;
            case 3:
                orderChannel = LECTURER;
                break;
            case 4:
                orderChannel = TEACHING_ASSISTANT;
                break;
            case 5:
                orderChannel = UN_KNOWN;
                break;
            default:
                orderChannel = null;
                break;
        }
        return orderChannel;
    }
}
