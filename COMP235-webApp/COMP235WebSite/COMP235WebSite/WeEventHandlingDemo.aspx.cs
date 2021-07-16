using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace COMP235WebSite
{
    public partial class WeEventHandlingDemo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            IblLastPostBack.Text = DateTime.Now.ToString();

            if (!Page.IsPostBack)
            {
                IblTimeHere.Text = DateTime.Now.ToString();
                IblLastPostBack.Text = "";
            }
            
        }

       
        protected void ShowPassword_Click(object sender, EventArgs e)
        {
            string password = txtPassword.Text;
            clearText.Text = password;
        }

    }
}