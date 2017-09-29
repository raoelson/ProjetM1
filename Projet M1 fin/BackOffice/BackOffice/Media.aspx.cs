using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BackOffice
{
    public partial class Media : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        [System.Web.Services.WebMethod]
        public static ServiceWs.media[] ListeMedia()
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.getAllMedia();
        }

        [System.Web.Services.WebMethod]
        public static ServiceWs.media SearchMedia(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.searchMedia(id);
        }
    }
}