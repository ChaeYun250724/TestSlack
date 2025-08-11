package com.anpetna.core;

import com.anpetna.constant.ImageTarget;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity extends BaseEntity {

    @Id
    @Column(name="item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;

    private String imgName; // 이미지 파일명
    private String oriImgName; // 원본 이미지 파일명
    private String imgUrl; //  이미지 조회 경로
    private String repimgYn; // 대표이미지 여부

    @Enumerated(EnumType.STRING)
    private ImageTarget imageTarget;

    @JoinColumn(name = "targetId")
    private String targetId;

/*    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }*/
}

