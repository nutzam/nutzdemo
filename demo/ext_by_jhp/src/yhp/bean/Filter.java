package yhp.bean;

import lombok.Data;

@Data
public class Filter {
	private String type;
	private String comparison;
	private String value;
	private String field;
}
