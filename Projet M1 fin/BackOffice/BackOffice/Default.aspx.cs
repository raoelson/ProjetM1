using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BackOffice
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        [System.Web.Services.WebMethod]
        public static int verify(String login, String password)
        {
            int rep = 0;
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ServiceWs.utilisateurs obj = ws.AdminVerify(login, password);
            if (obj.username != null)
            {
                HttpContext.Current.Session["user"] = obj.username;
                HttpContext.Current.Session["id_user"] = obj.id;
                rep = 1;
            }
            //HttpContext.Current.Session[""] = "";
            return rep;
        }
        [System.Web.Services.WebMethod]
        public static int logout()
        {
            HttpContext.Current.Session.RemoveAll();
            return 1;
        }
    }
}