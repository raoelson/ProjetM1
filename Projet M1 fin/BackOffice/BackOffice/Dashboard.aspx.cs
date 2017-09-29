using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BackOffice
{
    public partial class Dashboard : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if ((String)Session["user"] == null)
                Response.Redirect("/Default.aspx");
            else
            {
                ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
                String cout = ws.countCommandes();
                String[] longue = cout.Split('/');
                Session["valid"] = longue[0];
                Session["nonvalid"] = longue[1];
                Session["ut"] = longue[2];
            }
        }
        [System.Web.Services.WebMethod]
        public static String ListCharts()
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.countJCommandes();
        }
    }
}