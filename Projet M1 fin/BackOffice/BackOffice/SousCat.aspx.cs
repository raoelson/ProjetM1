using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BackOffice
{
    public partial class SousCat : System.Web.UI.Page
    {
       protected void Page_Load(object sender, EventArgs e)
        {
            //radio1.Items.Add(new ListItem("Apple", "1"));
            if ((String)Session["user"] != null)
            {
                ChargementCombo();
            }
            else
            {
                Response.Redirect("Default.aspx");
            }
        }

        void ChargementCombo()
        {
            CatList.DataSource = CreateDataSource();
            CatList.DataTextField = "CatTextField";
            CatList.DataValueField = "CatValueField";

            // Bind the data to the control.
            CatList.DataBind();

            // Set the default selected item, if desired.
            CatList.SelectedIndex = 0;

        }
        DataRow CreateRow(String Text, int Value, DataTable dt)
        {
            DataRow dr = dt.NewRow();
            dr[0] = Text;
            dr[1] = Value;

            return dr;

        }
        ICollection CreateDataSource()
        {

            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            DataTable dt = new DataTable();


            dt.Columns.Add(new DataColumn("CatTextField", typeof(String)));
            dt.Columns.Add(new DataColumn("CatValueField", typeof(String)));

            ServiceWs.categories[] cat = ws.getAllCategories();
            dt.Rows.Add(CreateRow("-------- CHOISISSIEZ ------- ", 0, dt));
            for (int i = 0; i < cat.Length; i++)
            {
                dt.Rows.Add(CreateRow(cat[i].nom, cat[i].id, dt));
            }
            DataView dv = new DataView(dt);
            return dv;

        }

        [System.Web.Services.WebMethod]
        public static ServiceWs.sousCategories[] Listsouscategories()
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.ListSousCat();
        }

        [System.Web.Services.WebMethod]
        public static ServiceWs.sousCategories Searchsouscategories(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.findSouscat(id);
        }

        [System.Web.Services.WebMethod]
        public static int UpdatesousCategories(String id, String cat, String nom)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.editSouscat(id, nom, cat);
            return 1;
        }

        [System.Web.Services.WebMethod]
        public static int AddsousCategories(String cat, String nom)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.addSouscat(nom, cat);
            return 1;
        }

        [System.Web.Services.WebMethod]
        public static String Deletesouscategories(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.deleteSouscat(id);
            return id;
        }
    }
    
}