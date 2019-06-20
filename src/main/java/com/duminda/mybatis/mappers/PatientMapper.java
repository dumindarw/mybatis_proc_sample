package com.duminda.mybatis.mappers;

import com.duminda.mybatis.models.PatientCount;
import com.duminda.mybatis.models.Patient;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface PatientMapper {

    @Insert("insert into patient(name,email,gender) values(#{name},#{email},#{gender})")
    @SelectKey(statement="call identity()", keyProperty="id",
            before=false, resultType=Integer.class)
    void insertPatient(Patient patient);

    @Select("select id, name, email, gender from patient WHERE id=#{id}")
    Patient findPatientById(@Param("id") Integer id);

    @Select("select id, name, email, gender from patient")
    List<Patient> findAllPatients();

    /*Calling procedure with OUT params */
    @Select(value= "{ CALL proc_getPatientCount( #{total, mode=OUT, jdbcType=INTEGER} )}")
    @Options(statementType = StatementType.CALLABLE)
    Object findPatientTotal(com.duminda.mybatis.models.Param param);

    /*Calling procedure without IN/OUT params */
    @Select(value= "{ CALL proc_getPatientCountByGender(  )}")
    @Options(statementType = StatementType.CALLABLE)
    List<PatientCount> findPatientCountByGender();

}
