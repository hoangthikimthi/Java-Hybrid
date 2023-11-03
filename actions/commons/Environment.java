package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:dev.properties" })
public interface Environment extends Config {

	String url();

	@Key("db.host")
	String getDBHostName();

	@Key("db.username")
	String getDBUserName();

	@Key("db.password")
	String getDBPassword();

}
