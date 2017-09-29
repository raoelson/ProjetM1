using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Collections;


namespace BackOffice
{
    public partial class Categories : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                if ((String)Session["user"] != null)
                {
                    ChargementCombo();
                }
                else
                {
                    Response.Redirect("Default.aspx");
                }
               

            }
        }

        //protected void buttonDelete_Click(object sender, EventArgs e)
        //{
        //    Button btn = sender as Button;
        //    GridViewRow grow = btn.NamingContainer as GridViewRow;
        //    String id = (grow.FindControl("lblID") as Label).Text;            
        //        int rep = ws.DeleteCategories(id);
        //        if(rep ==0){
        //            Session["message"] = "Deleted Successfully";
        //            Response.Redirect("Categories.aspx");                                        
        //        }

        //}

        //void ChargementTableau()
        //{
        //    ServiceWs.categories[] cat = ws.getAllCategories();
        //    DataTable dt = new DataTable();
        //    dt.Columns.Add("#");
        //    dt.Columns.Add("Images");
        //    dt.Columns.Add("Nom");
        //    dt.Columns.Add("Action");
        //    for (int i = 0; i < cat.Count(); i++)
        //    {
        //        dt.Rows.Add();
        //        dt.Rows[i]["#"] = cat[i].id;
        //        dt.Rows[i]["Images"] = cat[i].imageId.path;
        //        dt.Rows[i]["Nom"] = cat[i].nom;
        //    }
        //    //catTable.DataSource = dt;
        //    //catTable.DataBind();

        //}


        //protected void btnClear_Click(object sender, EventArgs e)
        //{
        //    ClearText();
        //}

        //void ClearText()
        //{
        //    txtId.Text = "";
        //    txtNom.Text = "";           
        //}


        //protected void btnUpdate_Click(object sender, EventArgs e)
        //{

        //    ws.edtiCategories(txtId.Text, MediaList.SelectedValue, txtNom.Text);
        //    Session["message"] = "Edit Successfully";
        //    ChargementTableau();
        //    ClearText();
        //}

        void ChargementCombo()
        {
            MediaList.DataSource = CreateDataSource();
            MediaList.DataTextField = "MediaTextField";
            MediaList.DataValueField = "MediaValueField";

            // Bind the data to the control.
            MediaList.DataBind();

            // Set the default selected item, if desired.
            MediaList.SelectedIndex = 0;

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

        [System.Web.Services.WebMethod]
        public static ServiceWs.categories searchEdit(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.findCategories(id);
        }

        [System.Web.Services.WebMethod]
        public static ServiceWs.categories[] Listcategories(int debut)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            return ws.getAllCategories();
        }

        [System.Web.Services.WebMethod]
        public static int Updatecategories(String id, String image, String nom)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.edtiCategories(id, image, nom);
            return 1;
        }
        [System.Web.Services.WebMethod]
        public static Int32 Deletecategories(String id)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.deleteCategories(id);
            return Convert.ToInt32(id);
        }
        [System.Web.Services.WebMethod]
        public static int Addcategories(String image, String nom)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ws.AddCategories(image, nom);
            return 1;
        }
    }
}