package com.agileengine.test;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class Image implements Serializable {

    String id;

    String cropped_picture;
}
