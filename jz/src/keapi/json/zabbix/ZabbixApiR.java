package keapi.json.zabbix;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ZabbixApiR 
{
  private ZabbixApi zabbixApi;

  public ZabbixApiR(ZabbixApi zabbixApi)
  {
    this.zabbixApi = zabbixApi;
  }
  
  //---------------------
  public String[] getHostGroupAll() throws ZabbixApiException 
  {
    String[] groups;

    try 
    {
      JSONObject params = new JSONObject();
      
      params.put("output", "extend");

      JSONArray responseJSON = zabbixApi.getJSONArray("hostgroup.get", params);
      
      int count = responseJSON.length();
      
      groups = new String[count];
      for(int i=0;i<count;i++)
      {
        groups[i] = responseJSON.getJSONObject(i).getString("name");
      }
    } 
    catch (JSONException e) 
    {
      throw new ZabbixApiException(e.getMessage());
    }

    return groups;
  }
  

  
  
  //--------------------- sort by name
  public String[] getHostGroup() throws ZabbixApiException 
  {
    String[] groups;

    try 
    {
      JSONObject params = new JSONObject();
      
      String[] oparm = new String[2];
      oparm[0]="groupid";
      oparm[1]="name";
      
      params.put("output", oparm);
      params.put("monitored_hosts", "1");
      params.put("sortfield", "name");
      //params.put("sortorder", "1");

      JSONArray responseJSON = zabbixApi.getJSONArray("hostgroup.get", params);
      
      int count = responseJSON.length();
      
      groups = new String[count];
      for(int i=0;i<count;i++)
      {
        groups[i]  = responseJSON.getJSONObject(i).getString("name");
        groups[i] += ";";
        groups[i] += responseJSON.getJSONObject(i).getString("groupid");
        groups[i] += ";";
      }
    } 
    catch (JSONException e) 
    {
      throw new ZabbixApiException(e.getMessage());
    }

    return groups;
  }
  
  

  
  
  //---------------------
  public String[] getHostGroup(String sf) throws ZabbixApiException 
  {
    String[] groups;

    try 
    {
      JSONObject params = new JSONObject();
      
      String[] oparm = new String[2];
      oparm[0]="groupid";
      oparm[1]="name";
      
      params.put("output", oparm);
      params.put("monitored_hosts", "1");
      params.put("sortfield", sf);
//      params.put("sortorder", "1");

      JSONArray responseJSON = zabbixApi.getJSONArray("hostgroup.get", params);
      
      int count = responseJSON.length();
      
      groups = new String[count];
      for(int i=0;i<count;i++)
      {
        groups[i]  = responseJSON.getJSONObject(i).getString("name");
        groups[i] += ";";
        groups[i] += responseJSON.getJSONObject(i).getString("groupid");
        groups[i] += ";";
      }
    } 
    catch (JSONException e) 
    {
      throw new ZabbixApiException(e.getMessage());
    }

    return groups;
  }
  
  
  
  
  
  
}