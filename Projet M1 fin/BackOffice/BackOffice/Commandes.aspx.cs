using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BackOffice
{
    public partial class Commandes : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if ((String)Session["user"] == null)
                Response.Redirect("Default.aspx"); 
        }

        [System.Web.Services.WebMethod]
        public static ServiceWs.commandes[] ListCommandes()
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.getAllCommandes();
        }
        [System.Web.Services.WebMethod]
        public static int Updatecommandes(String id, bool valid)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.editCommandes(id, valid);
            return 1;
        }
    }
}