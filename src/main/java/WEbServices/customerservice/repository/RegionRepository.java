package WEbServices.customerservice.repository;

import WEbServices.customerservice.dto.Region;
import WEbServices.customerservice.dto.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Region> getRegions() {
        return jdbcTemplate.query("SELECT * FROM region;", new BeanPropertyRowMapper<Region>(Region.class));
    }

    public Region getRegion(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM region WHERE id ="+id+";", new BeanPropertyRowMapper<Region>(Region.class));
    }

    public RespuestaApi createRegion(Region region){
        String reg = region.getRegion();
        jdbcTemplate.update("INSERT INTO region (region) VALUES('"+reg+"');");
        return new RespuestaApi("La región ha sido registrada");
    }

    public RespuestaApi updateRegion(Region region, int id) {
        String reg = region.getRegion();
        jdbcTemplate.update("UPDATE region SET region ='"+reg+"' WHERE id = "+id+";");
        RespuestaApi msg = new RespuestaApi("La región ha sido actualizada");
        return msg;
    }

    public RespuestaApi deleteRegion(int id){
        jdbcTemplate.update("DELETE FROM region WHERE id = "+id+";");
        return new RespuestaApi("La región ha sido eliminada");
    }
}
