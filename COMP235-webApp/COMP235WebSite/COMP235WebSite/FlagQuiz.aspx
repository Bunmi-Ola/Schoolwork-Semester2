<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="FlagQuiz.aspx.cs" Inherits="COMP235WebSite.FlagQuiz" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <%--AutoPostBack="True when form have no button"--%>
            <asp:RadioButtonList ID="redFlags" runat="server" AutoPostBack="False" OnSelectedIndexChanged="redFlags_SelectedIndexChanged">
                <asp:ListItem>Australia</asp:ListItem>
                  <asp:ListItem Value="Brazil">Brazil</asp:ListItem>
                  <asp:ListItem Value="China">China</asp:ListItem>
                  <asp:ListItem Value="Italy">Italy</asp:ListItem>
                  <asp:ListItem Value="Russia">Russia</asp:ListItem>
                 <asp:ListItem Value="SouthAfrica">South-Africa</asp:ListItem>
                 <asp:ListItem Value="Spain">Spain</asp:ListItem>
                 <asp:ListItem Value="UnitedStates">United-States</asp:ListItem>
            </asp:RadioButtonList>
            <br />
            <br />
            <asp:Image ID="ImgFlag" runat="server" />
            <br />
            <br />
            <asp:Button ID="Button1" runat="server" Text="Button" />
        </div>
    </form>
</body>
</html>
