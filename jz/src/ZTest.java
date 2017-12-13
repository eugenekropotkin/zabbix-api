
import keapi.json.zabbix.*;


public class ZTest 
{

	public static void main(String[] args) 
	{

		ZabbixApi zabbixApi = new ZabbixApi("https://zabbix.url/api_jsonrpc.php");

		try 
		{

			zabbixApi.auth("username", "secretpass");

			ZabbixApiR za = new ZabbixApiR(zabbixApi);
			
			for (String name : za.getHostGroup("name")) 
			{
				System.out.println(name);
			}
			
		} 
		catch (ZabbixApiException e) 
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("---\nFinished\n");
	}

}

