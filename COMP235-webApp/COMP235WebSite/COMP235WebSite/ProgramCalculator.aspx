<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProgramCalculator.aspx.cs" Inherits="COMP235WebSite.ProgramCalculator" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 40%;
        }
        .auto-style2 {
            height: 23px;
            text-align: left;
            width: 128px;
        }
        .auto-style3 {
            height: 23px;
            text-align: right;
            width: 36%;
        }
        .auto-style5 {
            height: 315px;
            text-align: center;
        }
        .auto-style7 {
            text-align: right;
            width: 36%;
        }
        .auto-style9 {
            text-align: left;
            width: 128px;
        }
        .auto-style10 {
            text-align: right;
            width: 36%;
            height: 26px;
        }
        .auto-style11 {
            text-align: left;
            width: 128px;
            height: 26px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style10">Price</td>
                    <td class="auto-style11">
                        <asp:TextBox ID="txtPrice" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style7">Down Payment</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="txtDown" runat="server" style="margin-left: 0px"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3">Interest Rate</td>
                    <td class="auto-style2">
                        <asp:TextBox ID="txtRate" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style5" colspan="2">
                        <asp:Button ID="btnCal" runat="server" OnClick="btnCal_Click" style="text-align: center" Text="Calculate" />
                        <br />
                        <asp:ListBox ID="lstResult" runat="server" Height="266px" Width="310px"></asp:ListBox>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
