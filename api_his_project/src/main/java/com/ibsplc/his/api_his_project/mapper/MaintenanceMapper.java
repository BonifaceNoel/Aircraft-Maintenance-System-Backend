package com.ibsplc.his.api_his_project.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.bo.MaintenanceRecord;
import com.ibsplc.his.api_his_project.bo.MaintenanceStatusDTO;

@Mapper
public interface MaintenanceMapper {

	@Select("SELECT * FROM `aircraft_maintenance_system`.`flight_info`")
	List<FlightInfo> getFlightsRegistered();

	@Select("SELECT * FROM `aircraft_maintenance_system`.`maintenance_record`")
	List<MaintenanceRecord> getMaintenanceRegister();

	@Select("SELECT \r\n"
			+ "	`flight_info`.`aircraft_id`,\r\n"
			+ "    `flight_info`.`flight_model`,\r\n"
			+ "    `flight_info`.`flight_status`,\r\n"
			+ "    `maintenance_record`.`maintenance_id`,\r\n"
			+ "    `maintenance_record`.`maintenance_type`,\r\n"
			+ "    `maintenance_record`.`maintenance_status`,\r\n"
			+ "    `maintenance_record`.`completion_date`,\r\n"
			+ "    `maintenance_record`.`maintenance_progress`\r\n"
			+ "FROM \r\n"
			+ "	`aircraft_maintenance_system`.`flight_info`\r\n"
			+ "INNER JOIN \r\n"
			+ "	`aircraft_maintenance_system`.`maintenance_record` \r\n"
			+ "ON \r\n"
			+ "	`flight_info`.`aircraft_id`=`maintenance_record`.`flight_id`\r\n"
			+ "WHERE\r\n"
			+ "	`maintenance_record`.`maintenance_status` = #{status}")
	List<MaintenanceStatusDTO> getMaintenanceDetails(@Param("status") String status);

	@Select("SELECT \r\n"
			+ "	`flight_info`.`aircraft_id`,\r\n"
			+ "    `flight_info`.`flight_model`,\r\n"
			+ "    `flight_info`.`flight_status`,\r\n"
			+ "    `maintenance_record`.`maintenance_id`,\r\n"
			+ "    `maintenance_record`.`maintenance_type`,\r\n"
			+ "    `maintenance_record`.`maintenance_status`,\r\n"
			+ "    `maintenance_record`.`completion_date`,\r\n"
			+ "    `maintenance_record`.`maintenance_progress`\r\n"
			+ "FROM \r\n"
			+ "	`aircraft_maintenance_system`.`flight_info`\r\n"
			+ "INNER JOIN \r\n"
			+ "	`aircraft_maintenance_system`.`maintenance_record` \r\n"
			+ "ON \r\n"
			+ "	`flight_info`.`aircraft_id` = `maintenance_record`.`flight_id`")
	List<MaintenanceStatusDTO> getFlightsUnderMaintenance();

	@Insert("INSERT INTO `aircraft_maintenance_system`.`flight_info` (\r\n"
			+ "    `aircraft_id`,\r\n"
			+ "    `reg_num`,\r\n"
			+ "    `flight_model`,\r\n"
			+ "    `airline`,\r\n"
			+ "    `airline_id`,\r\n"
			+ "    `flight_class`,\r\n"
			+ "    `flight_status`\r\n"
			+ ") VALUES\r\n"
			+ "(#{aid}, #{rnum}, #{model}, #{airline}, #{airid}, #{fclass}, #{status})")
	void newFlightDetails(@Param("aid") String aid, @Param("rnum") int rnum, @Param("model") String model, @Param("airline") String airline, @Param("airid") String airid, @Param("fclass") String fclass, @Param("status") String status);

	@Insert("INSERT INTO `aircraft_maintenance_system`.`maintenance_record` (\r\n"
			+ "    `maintenance_id`,\r\n"
			+ "    `flight_id`,\r\n"
			+ "    `maintenance_type`,\r\n"
			+ "    `issue_description`,\r\n"
			+ "    `arrival_date`,\r\n"
			+ "    `completion_date`,\r\n"
			+ "    `maintenance_status`,\r\n"
			+ "    `maintenance_progress`\r\n"
			+ ") VALUES\r\n"
			+ "(#{mid}, #{fid}, #{type}, #{issue}, #{arrive}, #{complete}, #{mainStatus}, #{progress})")
	void newMaintenanceDetails(@Param("mid") String mid, @Param("fid") String fid, @Param("type") String type, @Param("issue") String issue, @Param("arrive") Date arrive, @Param("complete") Date complete, @Param("mainStatus") String mainStatus, @Param("progress") double progress);

	@Update("UPDATE `flight_info`\r\n"
			+ "SET reg_num = #{rnum},\r\n"
			+ "    flight_model = #{fmodel},\r\n"
			+ "    airline = #{airline},\r\n"
			+ "    airline_id = #{airid},\r\n"
			+ "    flight_class = #{fclass},\r\n"
			+ "    flight_status = #{fstatus} \r\n"
			+ "WHERE aircraft_id = #{aid};")
	void updateFlight(@Param("rnum") int rnum, @Param("fmodel") String fmodel, @Param("airline") String airline, @Param("airid") String airid, @Param("fclass") String fclass, @Param("fstatus") String fstatus, @Param("aid") String aid);

	@Update("UPDATE `maintenance_record`\r\n"
			+ "SET \r\n"
			+ "    flight_id = #{fid},\r\n"
			+ "    maintenance_type = #{mtype},\r\n"
			+ "    issue_description = #{idesc},\r\n"
			+ "    arrival_date = #{adate},\r\n"
			+ "    completion_date = #{cdate},\r\n"
			+ "    maintenance_status = #{mstatus},\r\n"
			+ "    maintenance_progress = #{mprogress} \r\n"
			+ "WHERE maintenance_id = #{mid};")
	void updateDamage(@Param("fid") String fid, @Param("mtype") String mtype, @Param("idesc") String idesc, @Param("adate") Date adate, @Param("cdate") Date cdate, @Param("mstatus") String mstatus, @Param("mprogress") double mprogress, @Param("mid") String mid);

	@Delete("DELETE FROM `flight_info` WHERE aircraft_id = #{aid}")
	void deleteFlight(@Param("aid") String aid);

	@Delete("DELETE FROM `maintenance_record` WHERE maintenance_id = #{mid}")
	void deleteRecord(@Param("mid") String mid);

	@Select("SELECT * FROM `aircraft_maintenance_system`.`flight_info`")
	List<FlightInfo> getFlight();

	@Select("SELECT * FROM `aircraft_maintenance_system`.`maintenance_record`")
	List<MaintenanceRecord> getRecord();
}
