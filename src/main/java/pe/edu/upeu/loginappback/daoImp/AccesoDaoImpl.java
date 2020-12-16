package pe.edu.upeu.loginappback.daoImp;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.internal.OracleTypes;
import pe.edu.upeu.loginappback.dao.AccesoDao;
import pe.edu.upeu.loginappback.entity.Acceso;

@Repository
public class AccesoDaoImpl implements AccesoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Acceso a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Acceso a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		String SQL = "select a.nomacceso, a.url, a.icono,a.idacceso from acceso a  JOIN roles_acceso ra ON (a.idacceso = ra.idacceso) JOIN roles r ON (ra.idrol = r.idrol) JOIN usuarios_roles ur ON (r.idrol = ur.idrol)  JOIN usuarios u ON ur.idusuario = u.idusuario WHERE u.idpersona=?";
		return jdbcTemplate.queryForList(SQL, new Object[] { id });
	}

	@Override
	public Map<String, Object> readAll(String username) {
		String SQL = "select a.nomacceso, a.url, a.icono,a.idacceso from acceso a  JOIN roles_acceso ra ON (a.idacceso = ra.idacceso) JOIN roles r ON (ra.idrol = r.idrol) JOIN usuarios_roles ur ON (r.idrol = ur.idrol)  JOIN usuarios u ON ur.idusuario = u.idusuario WHERE u.username=?";
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAllSubMains(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_acceso")
				.withProcedureName("SPP_read_accesochild")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("idcc", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

}
