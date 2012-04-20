package yhp.module;

import org.nutz.dao.Cnd;

import yhp.bean.Filter;
import yhp.bean.Sorter;

public class Utils {

	public static Cnd filter2Cnd(Filter[] filters, Sorter[] sorters) {
		Cnd cnd = Cnd.where("id", ">=", 0);
		if (filters != null) {
			for (int i = 0; i < filters.length; i++) {
				Filter filter = filters[i];
				if (filter.getType().equals("numeric")) {
					if (filter.getComparison().equals("eq"))
						cnd = cnd.and(filter.getField(), "=",
								Integer.parseInt(filter.getValue()));
					if (filter.getComparison().equals("lt"))
						cnd = cnd.and(filter.getField(), "<",
								Integer.parseInt(filter.getValue()));
					if (filter.getComparison().equals("gt"))
						cnd = cnd.and(filter.getField(), ">",
								Integer.parseInt(filter.getValue()));
				} else if (filter.getType().equals("string")) {
					cnd = cnd.and(filter.getField(), "like",
							"%" + filter.getValue() + "%");
				} else if (filter.getType().equals("list")) {
					if (filter.getValue().indexOf(",") == -1)
						cnd = cnd
								.and(filter.getField(), "=", filter.getValue());
					else {
						String[] values = filter.getValue().split(",");

						cnd = cnd.and(filter.getField(), "in", values);
					}
				} else if (filter.getType().equals("boolean")) {
					if (filter.getValue().equals("true"))
						cnd = cnd.and(filter.getField(), "=", 1);
					else
						cnd = cnd.and(filter.getField(), "=", 0);
				} else if (filter.getType().equals("date")) {
					if (filter.getComparison().equals("eq"))
						cnd = cnd.and(filter.getField(), "=",
								formatDate(filter.getValue()));
					if (filter.getComparison().equals("lt"))
						cnd = cnd.and(filter.getField(), "<",
								formatDate(filter.getValue()));
					if (filter.getComparison().equals("gt"))
						cnd = cnd.and(filter.getField(), ">",
								formatDate(filter.getValue()));

				}
			}
		}
		if (sorters != null && sorters.length > 0) {
			if (sorters[0].getDirection().equals("DESC")) {
				cnd.desc(sorters[0].getProperty());
			} else {
				cnd.asc(sorters[0].getProperty());
			}
		}
		return cnd;
	}

	public static String formatDate(String source) {
		String[] p = source.split("/");
		return p[2] + "-" + p[0] + "-" + p[1] + " 00:00:00";
	}
}
