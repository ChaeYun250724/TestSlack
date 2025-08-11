package com.anpetna.member.repository;

import com.anpetna.core.BaseEntity;
import com.anpetna.core.ImageEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    private Long id;

    private String name;
    private String password;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageEntity> memberImages = new ArrayList<>();

    public void addItemImage(ImageEntity imageEntity) {
        this.memberImages.add(imageEntity); // Collection 메서드 //조회용 객체
        imageEntity.setMember(this);//manyToOne활성화
    }

}
