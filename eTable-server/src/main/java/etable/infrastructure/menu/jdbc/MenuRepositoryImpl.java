package etable.infrastructure.menu.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import etable.domain.menu.model.Item;
import etable.domain.menu.model.SubItem;
import etable.domain.menu.repository.MenuRepository;
import etable.web.constants.querys.Query;

@Component
public class MenuRepositoryImpl implements MenuRepository{

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	private MenuRowMapper row;

	@Override
	public List<Item> getItems() {
		String query = Query.selectFrom(Query.table_menuitems);
		List<Map<String, Object>> rows = this.jdbctemplate.queryForList(query);
		List<Item> items = row.mapRowItem(rows);
		return items;
	}

	@Override
	public List<SubItem> getSubItems() {
		String query = Query.selectFrom(Query.table_menusubitems);
		List<Map<String, Object>> rows = this.jdbctemplate.queryForList(query);
		List<SubItem> subitems = row.mapRowSubItem(rows);
		return subitems;
	}

	@Override
	public List<SubItem> getSubItemByItem(int citem) {
		String query = Query.selectFromWhere(Query.table_menusubitems, "CITEM", citem);
		List<Map<String, Object>> rows = this.jdbctemplate.queryForList(query);
		List<SubItem> subitems = row.mapRowSubItem(rows);
		return subitems;
	}
	
	
}
