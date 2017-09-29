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
    public partial class Produits : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if ((String)Session["user"] != null)
            {
                ChargementCat();
                ChargementMedia();
                ChargementTVA();
            }
            else
            {
                Response.Redirect("Default.aspx");
            }

        }
        [System.Web.Services.WebMethod]
        public static ServiceWs.produit[] ListProduits()
        {
            //JavaScriptSerializer serializer = new JavaScriptSerializer();            
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            //serializer.Serialize(ws.getAllProduits());
            return ws.getAllProduits();
        }
        void ChargementCat()
        {
            CatList_.DataSource = CreateDataSource();
            CatList_.DataTextField = "CatTextField";
            CatList_.DataValueField = "CatValueField";

            // Bind the data to the control.
            CatList_.DataBind();

            // Set the default selected item, if desired.
            CatList_.SelectedIndex = 0;

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

            ServiceWs.sousCategories[] cat = ws.ListSousCat();
            dt.Rows.Add(CreateRow("-------- CHOISISSIEZ ------- ", 0, dt));
            for (int i = 0; i < cat.Length; i++)
            {
                dt.Rows.Add(CreateRow(cat[i].nom, cat[i].id, dt));
            }
            DataView dv = new DataView(dt);
            return dv;

        }
        void ChargementMedia()
        {
            MediaList_.DataSource = CreateDataSource_();
            MediaList_.DataTextField = "MediaTextField";
            MediaList_.DataValueField = "MediaValueField";

            // Bind the data to the control.
            MediaList_.DataBind();

            // Set the default selected item, if desired.
            MediaList_.SelectedIndex = 0;

        }
        ICollection CreateDataSource_()
        {

            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            DataTable dt = new DataTable();


            dt.Columns.Add(new DataColumn("MediaTextField", typeof(String)));
            dt.Columns.Add(new DataColumn("MediaValueField", typeof(String)));

            ServiceWs.media[] media = ws.getAllMedia();
            dt.Rows.Add(CreateRow("-------- CHOISISSIEZ ------- ", 0, dt));
            for (int i = 0; i < media.Length; i++)
            {
                dt.Rows.Add(CreateRow(media[i].alt, media[i].id, dt));
            }
            DataView dv = new DataView(dt);
            return dv;

        }
        void ChargementTVA()
        {
            TvaList.DataSource = CreateData();
            TvaList.DataTextField = "TVATextField";
            TvaList.DataValueField = "TVAValueField";

            // Bind the data to the control.
            TvaList.DataBind();

            // Set the default selected item, if desired.
            TvaList.SelectedIndex = 0;

        }
        ICollection CreateData()
        {

            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            DataTable dt = new DataTable();


            dt.Columns.Add(new DataColumn("TVATextField", typeof(String)));
            dt.Columns.Add(new DataColumn("TVAValueField", typeof(String)));

            ServiceWs.tva[] tva = ws.getAllTva();
            dt.Rows.Add(CreateRow("-------- CHOISISSIEZ ------- ", 0, dt));
            for (int i = 0; i < tva.Length; i++)
            {
                dt.Rows.Add(CreateRow(tva[i].nom, tva[i].id, dt));
            }
            DataView dv = new DataView(dt);
            return dv;

        }

        [System.Web.Services.WebMethod]
        public static ServiceWs.produit SearchProduits(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.FindProduit(id);
        }

        [System.Web.Services.WebMethod]
        public static int UpdateProduits(String id, String nom, String cat, String media
            , String tva, String desc, String prix, String dispo)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.editProduits(id, media, tva, cat, nom, desc, prix, dispo);
            return 1;
        }
        [System.Web.Services.WebMethod]
        public static int addProduits(String nom, String cat, String media
            , String tva, String desc, String prix, String dispo)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.AddProduits(media, tva, cat, nom, desc, prix, dispo);
            return 1;
        }
        [System.Web.Services.WebMethod]
        public static String Deleteproduits(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.DeleteProduits(id);
            return id;
        }
    }
}