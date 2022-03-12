package com.example.historydiseases.core;

import java.io.Serializable;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@TypeDefs( {
        @TypeDef( name = "json", typeClass = JsonStringType.class ),
        @TypeDef( name = "jsonb", typeClass = JsonBinaryType.class )
} )

public class BaseEntity implements Serializable {

}
