using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace BackOffice
{
    /// <summary>
    /// Description résumée de GenericHandler
    /// </summary>
    public class GenericHandler : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            ServiceWs.CommandesWsClient ws = new ServiceWs.CommandesWsClient();

            if (context.Request.Files.Count > 0)
            {
                string fname = "";
                String str = context.Request.Form["alt"];
                //HttpFileCollection files = context.Request.Files;                
                //for (int i = 0; i < files.Count; i++)
                //{
                //    HttpPostedFile file = files[i];
                //     fname = context.Server.MapPath("~/uploads/" + file.FileName);
                //    file.SaveAs(fname);
                //    str = file.FileName;
                //}
                HttpPostedFile postedFile = context.Request.Files["file"];
                fname = context.Server.MapPath("~/uploads/" + postedFile.FileName);
                postedFile.SaveAs(fname);
                ws.AddMedia("uploads/" + postedFile.FileName, str);
                context.Response.ContentType = "text/plain";
                context.Response.Write(1);
            }
            else
            {
                String id = context.Request.Form["id"];
                String path = context.Request.Form["path"];
                String path_ = context.Server.MapPath(path);
                ws.deleteMedia(id);
                FileInfo TheFile = new FileInfo(path_);
                if (TheFile.Exists)
                {
                    File.Delete(path_);
                }
                context.Response.ContentType = "text/plain";
                context.Response.Write(id);
            }

        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}