package keapi.json.zabbix;

public class ZabbixApiTest {
	public static void main(String[] args) {

		// api fixed: can be http & https
		ZabbixApi zabbixApi = new ZabbixApi("https://<server>/api_jsonrpc.php");

		try {
			zabbixApi.auth("username", "password");

			// Get groups list
			ZabbixApiR hostgroup = new ZabbixApiR(zabbixApi);
			for (String name : hostgroup.getHostGroupAll()) {
				System.out.println(name);
			}

		} catch (ZabbixApiException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}