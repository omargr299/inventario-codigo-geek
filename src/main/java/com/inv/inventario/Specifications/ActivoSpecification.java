package com.inv.inventario.Specifications;

import java.sql.Date;

import org.springframework.data.jpa.domain.Specification;
import org.w3c.dom.ranges.RangeException;

import com.inv.inventario.Exceptions.RangeDateException;
import com.inv.inventario.Models.Activo;
import com.inv.inventario.Models.Ubicacion;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;

public class ActivoSpecification {

    private ActivoSpecification() {
    }



    public static Specification<Activo> queryLike(String _query) {
        return (root, query, builder) -> {
            // Predicate idPredicate = builder.equal(root.get("IdActivo"), Integer.parseInt(_query) );
            Predicate nombrePredicate = builder.like(root.get("nombre"), "%" + _query + "%");
            return nombrePredicate;
        };
    }

    public static Specification<Activo> fechaAdquiLike(String fechaAdquiStart, String fechaAdquiEnd) {
        return (root, query, builder) -> {
            Date fechaAdquiDateStart = Date.valueOf(fechaAdquiStart);
            Date fechaAdquiDateEnd = Date.valueOf(fechaAdquiEnd);
            if (fechaAdquiDateStart.after(fechaAdquiDateEnd)) {
                throw new RangeDateException("La fecha de inicio debe ser menor a la fecha de fin");
            }
            return builder.between(root.get("fechaAdqui"),  fechaAdquiDateStart, fechaAdquiDateEnd);
        };
    }

    public static Specification<Activo> ubicacionLike(int idUbicacion) {
        return (root, query, builder) -> {
            Join<Activo, Ubicacion> ubicacionJoin = root.join("ubicacion");
            Predicate predicate1 = builder.equal(ubicacionJoin.get("IdUbicacion"), idUbicacion);
            Predicate predicate2 = builder.lessThanOrEqualTo(ubicacionJoin.get("IdUbicacion"), 2);
            return builder.and(predicate1,predicate2);
        };
    }

    public static Specification<Activo> remoteLike(int idUbicacion) {
        return (root, query, builder) -> {
            Join<Activo, Ubicacion> ubicacionJoin = root.join("ubicacion");
            return builder.greaterThan(ubicacionJoin.get("IdUbicacion"), 2);
        };

    }

    public static Specification<Activo> status(String status) {
        return (root, query, builder) -> builder.like(root.get("status"), "%" + status + "%");
    }
}
