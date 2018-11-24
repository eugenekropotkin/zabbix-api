
import keapi.json.zabbix.*;
import keapi.passwd.*;

public class ZTest 
{

	public static void main(String[] args) 
	{
		// Class = variables holder, hide real data from GitHub users :)
		ZabbixApiPasswd pwd = new ZabbixApiPasswd();
		
		// Create ZabbixAPI class
		ZabbixApi zabbixApi = new ZabbixApi(pwd.url);

		try 
		{
			//authenticate
			zabbixApi.auth(pwd.uname, pwd.pwd);

			// create class
			ZabbixApiR zbx = new ZabbixApiR(zabbixApi);
			
			// example: search for all {Hosts Groups} in zabbix
			System.out.println("GroupName;GroupID;");
			System.out.println("---");
			for (String name : zbx.getHostGroup("name")) 
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

