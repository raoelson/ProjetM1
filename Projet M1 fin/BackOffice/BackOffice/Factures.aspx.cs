using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using Newtonsoft.Json.Linq;
using System.Runtime.Serialization.Json;
using System.IO;
using System.Web.Script.Serialization;

namespace BackOffice
{
    public partial class Factures : System.Web.UI.Page
    {
        int total = 0;
        protected void Page_Load(object sender, EventArgs e)
        {
            if ((String)Session["user"] != null)
            {
                String id = Request.QueryString["id"];
                chargementTable(id); ;
                //Session["id_consulter"] = id;
            }
            else
            {
                Response.Redirect("Default.aspx");
            }
        }
        private void chargementTable(String id)
        {
            
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();
            ServiceWs.commandes commandes_ = ws.findCommands(id);
            JavaScriptSerializer ser = new JavaScriptSerializer();
            List<Commandes_Fact> response = ser.Deserialize<List<Commandes_Fact>>(commandes_.commandes1);

            DataSet ds = new DataSet();
            DataTable dt;
            DataRow dr;
            DataColumn Id;
            DataColumn Categories;
            DataColumn Quantite;
            DataColumn Prix;
            DataColumn Tva;
            DataColumn Total;
            dt = new DataTable();
            int i = 0;
            Id = new DataColumn("Id", Type.GetType("System.Int32"));
            Categories = new DataColumn("Categories", Type.GetType("System.String"));//System.Int32
            Quantite = new DataColumn("Quantite", Type.GetType("System.Int32"));
            Prix = new DataColumn("Prix", Type.GetType("System.String"));
            Tva = new DataColumn("Tva", Type.GetType("System.Single"));
            Total = new DataColumn("Total", Type.GetType("System.Single"));

            dt.Columns.Add(Id);
            dt.Columns.Add(Categories);
            dt.Columns.Add(Quantite);
            dt.Columns.Add(Prix);
            dt.Columns.Add(Tva);
            dt.Columns.Add(Total);
            float total_ = 0;
            foreach (var item in response)
            {
                total_ += item.Prix * item.Qte;

                dr = dt.NewRow();
                dr["Id"] = item.ID;
                dr["Categories"] = item.Cat;
                dr["Quantite"] = item.Qte;
                dr["Prix"] = item.Prix;
                dr["Tva"] = item.TVA;
                dr["Total"] = item.Prix * item.Qte;
                dt.Rows.Add(dr);
            }

            ds.Tables.Add(dt);

            listFact.DataSource = ds.Tables[0];
            listFact.DataBind();
            decimal total = Convert.ToDecimal(total_);                      
            listFact.FooterRow.Cells[0].Text = "Total";
            listFact.FooterRow.Cells[0].HorizontalAlign = HorizontalAlign.Right;
            listFact.FooterRow.Cells[4].Text = total.ToString("N2");
            listFact.FooterRow.Cells.RemoveAt(1);
            listFact.FooterRow.Cells.RemoveAt(2);
            listFact.FooterRow.Cells.RemoveAt(3);
            
            listFact.FooterRow.Cells[0].ColumnSpan = 4;
           
                                                
        }
        public static T JsonDeserialize<T>(string jsonString)
        {
            DataContractJsonSerializer ser = new DataContractJsonSerializer(typeof(T));
            MemoryStream ms = new MemoryStream(System.Text.Encoding.UTF8.GetBytes(jsonString));
            T obj = (T)ser.ReadObject(ms);
            return obj;
        }
        

        

    }
     
    public class Commandes_Fact
    {
        public string ID { get; set; }
        public string Cat { get; set; }

        public float TVA { get; set; }

        public int Qte { get; set; }

        public string Facture { get; set; }

        public string Livraison { get; set; }

        public int Prix { get; set; }

        public float multiplicate { get; set; }

      
    }    
}