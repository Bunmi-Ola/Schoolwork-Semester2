<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WeEventHandlingDemo.aspx.cs" Inherits="COMP235WebSite.WeEventHandlingDemo" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <%--asp is running on server side meaning it executive on the server before excuting.--%>
    <form id="form1" runat="server">
        <div>

            User Id:
            <asp:TextBox ID="textUserId" runat="server" Width="214px"></asp:TextBox>
            <br />
            <br />
            Password:&nbsp;
            <asp:TextBox ID="txtPassword" runat="server" type="Password" Width="193px">
</asp:TextBox>
            <br />
            <br />
            Clear Text Password:
            <asp:TextBox ID="clearText" runat="server" BorderStyle="Inset" Width="141px"></asp:TextBox>

            <br />
            <br />
            <br />
            <asp:Button ID="btnLogin_Button" runat="server" PostBackUrl="~/LandingPage.aspx" Text="Login" Width="102px" />

            <asp:Button ID="ShowPassword" runat="server" Text="Show Password" OnClick="ShowPassword_Click" Width="139px" />

            <br />
            <br />
            You cracked your last password at <asp:Label ID="IblLastPostBack" runat="server"></asp:Label>
            <br />
            <br />
            You have been cracking passwords since: <asp:Label ID="IblTimeHere" runat="server"></asp:Label>

        </div>
    </form>
</body>
</html>
