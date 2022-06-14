package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@DiscriminatorValue("B")
@Entity
public class Book extends Item{

    private String author;
    private String isbn;
}
